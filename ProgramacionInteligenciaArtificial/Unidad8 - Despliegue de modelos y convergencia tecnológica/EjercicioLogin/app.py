from flask import Flask, render_template, request

app = Flask(__name__)


diccionario = {
    "David": "david",
    "Miguel": "miguelin",
    "Carla": "Carla",
}


@app.route("/")
def home():
    return render_template("login.html")


@app.route("/acceso", methods=["POST"])
def procesarLogin():
    usuario = request.form.get("usuario")
    contrasenya = request.form.get("contrasenya")

    if usuario in diccionario and diccionario[usuario] == contrasenya:
        return render_template(
            "respuesta.html", tUsuario=usuario, tContrasenya=contrasenya
        )
    else:
        mensaje_error = "Datos de acceso erróneos. Por favor, introdúzcalos de nuevo."
        return render_template("login.html", error=mensaje_error)


@app.errorhandler(404)
def pagina_no_encontrada():
    return render_template("error.html", error="Página no encontrada (404)"), 404


if __name__ == "__main__":
    app.run(debug=True, port=8000)
