from controller import Robot, Supervisor
import math, time

# Creamos un Supervisor, que permite controlar el robot y eliminar nodos del mundo
robot = Supervisor()
timestep = int(robot.getBasicTimeStep())

# Obtener y configurar los motores de las ruedas
left_motors = []
right_motors = []

# Asociamos los motores a su grupo correspondiente
motor_names = [
    ("front left wheel", left_motors),
    ("back left wheel", left_motors),
    ("front right wheel", right_motors),
    ("back right wheel", right_motors)
]

# Configuramos cada motor para que gire indefinidamente con velocidad inicial
for name, group in motor_names:
    motor = robot.getDevice(name)
    motor.setPosition(float('inf'))  # Control de velocidad (no de posición)
    motor.setVelocity(6.5)           # Velocidad inicial
    group.append(motor)

# Función para encontrar todos los nodos de basura con nombre que comienza por "trash2"
def find_all_trash_nodes():
    trash_nodes = []
    root = robot.getRoot()
    children_field = root.getField("children")
    count = children_field.getCount()
    for i in range(count):
        node = children_field.getMFNode(i)
        if node.getDef() and node.getDef().startswith("trash2"):
            trash_nodes.append(node)
    return trash_nodes

# Obtenemos todos los nodos de basura al inicio
trash_nodes = find_all_trash_nodes()


# Parámetros de detección de colisión/contacto con basura
MOVEMENT_THRESHOLD = 0.01  # Consideramos que hay colisión si el movimiento es menor a 1 cm
X_THRESHOLD = 0.5          # Distancia lateral máxima para considerar contacto
Z_THRESHOLD = 0.1          # Distancia frontal máxima para considerar contacto

# Función para eliminar los objetos de basura si están suficientemente cerca del robot
def remove_trash_on_contact():
    global trash_nodes
    remaining = []
    robot_position = robot.getSelf().getField("translation").getSFVec3f()

    for node in trash_nodes:
        if node is not None:
            trash_position = node.getField("translation").getSFVec3f()
            dx = trash_position[0] - robot_position[0]
            dz = trash_position[2] - robot_position[2]

            if abs(dx) < X_THRESHOLD and abs(dz) < Z_THRESHOLD:
                print(f"Contacto con basura. Eliminando...")
                node.remove()
            else:
                remaining.append(node)
    trash_nodes = remaining

# Hace girar el robot hacia la izquierda un ángulo aproximado de 145 grados
def turn_left_145():
    rotation_time = 145 / 360 * 2 * math.pi / 1  # Tiempo estimado en segundos para rotar 145 grados
    steps = int((rotation_time / (timestep / 1000)))

    for _ in range(steps):
        for m in left_motors:
            m.setVelocity(-5.0)
        for m in right_motors:
            m.setVelocity(5.0)
        robot.step(timestep)

    # Restaurar velocidad de avance después de girar
    for m in left_motors + right_motors:
        m.setVelocity(6.5)


# Estado para controlar si ya giró después de chocar
has_turned = False

# Inicializamos la posición anterior del robot
prev_position = robot.getSelf().getField("translation").getSFVec3f()

# Número de pasos a ignorar al inicio de la simulación (para evitar falsos positivos de colisión y borrado)
IGNORE_STEPS = 250
step_counter = 0

# Bucle principal del controlador
while robot.step(timestep) != -1:
    # Calcula el movimiento del robot desde la última posición
    current_position = robot.getSelf().getField("translation").getSFVec3f()
    dx = current_position[0] - prev_position[0]
    dz = current_position[2] - prev_position[2]
    movement = math.sqrt(dx**2 + dz**2)

    # Si no se ha movido lo suficiente, consideramos que ha chocado
    if step_counter > IGNORE_STEPS:
        remove_trash_on_contact()   # Revisa si hay basura para eliminar

        if movement < MOVEMENT_THRESHOLD and not has_turned:
            print("Impacto detectado por falta de movimiento. Girando...")
            turn_left_145()
            has_turned = True
        elif movement >= MOVEMENT_THRESHOLD:
            has_turned = False

    # Actualizamos la posición anterior
    prev_position = current_position

    # Incrementamos el contador de pasos
    step_counter += 1