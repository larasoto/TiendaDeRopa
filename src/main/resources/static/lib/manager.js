var app = new Vue({
	el: "#app",
	data: {
		clientes: [],
		prendas: [],
		nombre: "",
		apellido: "",
		email: "",
		nombrePrenda: "",
		tipo: "",
		talles: [],
		precio: 0,
		stock: 0,
		imagen: "",
		json: "",
	},

	created() {
		this.cargarDatos()
		this.cargarPrendas()
	},

	methods: {
		cargarDatos() {
			axios
				.get("/rest/clientes")
				.then((response) => {
					this.clientes = response.data._embedded.clientes
					this.json = response.data
				})
				.catch((error) => {
					console.log(error)
				})
		},
		cargarPrendas() {
			axios
				.get("/api/prendas")
				.then((response) => {
					this.prendas = response.data
				})
				.catch((error) => {
					console.log(error)
				})
		},
		crearPrendas() {
			axios

				.post(
					"/api/prendas",
					`nombrePrenda=${this.nombrePrenda}&precio=${this.precio}&stock=${this.stock}&tipo=${this.tipo}&talles=${this.talles}&imagen=${this.imagen}`
				)
				.then((response) => {
					window.location.reload()
				})
				.catch((error) => {
					console.log(error)
				})
		},

		formulario() {
			return false
		},

		eliminarCuentas() {
			axios
				.delete("/api/prendas{Id}")
				.then((response) => {
					window.location.reload()
				})
				.catch((error) => {
					console.log(error)
				})
		},
	},
})

let prenda_foto = document.querySelector("#foto-prenda")
app.imagen = prenda_foto.src

const boton_foto = document.querySelector("#btn-foto")
const imagen = document.querySelector("#foto-prenda")

let widget_cloudinary = cloudinary.createUploadWidget(
	{
		cloudName: "dqt52hdyq",
		uploadPreset: "ykrwdnqr",
	},
	(err, result) => {
		if (!err && result & (result.event === "success")) {
			console.log("Imágen subida con éxito", result.info)
			imagen.src = result.info.secure_url
		}
	}
)

boton_foto.addEventListener(
	"click",
	() => {
		widget_cloudinary.open()
	},
	false
)
