import joblib
import numpy as np

from flask import Flask, render_template, request


app = Flask(__name__)

modelo = joblib.load("Flask/AnalisisPerfilCrediticio/modelo.pkl")


@app.route("/", methods=["GET", "POST"])
def introducirDatos():
    if request.method == "POST":
        # Obtener valores para la predicción
        prestamo = request.form.get("prestamo")
        ingresos = request.form.get("ingresos")
        tasa_interes = request.form.get("tasa_interes")
        posesion = request.form.get("posesion")

        # Realizar transformaciones necesarias
        prestamo = True if prestamo == "si" else False

        if posesion == "alquiler":
            alquiler = True
            hipoteca = False
        elif posesion == "hipoteca":
            hipoteca = True
            alquiler = False
        else:
            hipoteca = False
            alquiler = False

        # Agrupar datos
        datos = np.array(
            [
                [
                    bool(prestamo),
                    float(ingresos),
                    float(tasa_interes),
                    bool(alquiler),
                    bool(hipoteca),
                ]
            ]
        )
        print(datos)

        # Realizar predicción
        prediccion = modelo.predict(datos)

        # Mostrar resultado
        resultado = "concedido" if prediccion[0] == 1 else "denegado"

        return render_template(
            "mostrarPrediccion.html",
            tResultado=resultado,
        )

    return render_template("formularioDatos.html")


@app.errorhandler(404)
def pagina_no_encontrada(error):
    return render_template("error.html", mensaje="Página no encontrada (404)"), 404


if __name__ == "__main__":
    app.run(debug=True)
