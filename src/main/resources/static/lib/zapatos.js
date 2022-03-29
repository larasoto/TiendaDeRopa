var app = new Vue({
	el: "#app",
	data: {
		prendas: [],
		zapatos: [],
		buscador: "",
		setTimeoutBuscador: "",
		tildes: {
			á: "a",
			é: "e",
			è: "e",
			í: "i",
			ó: "o",
			ú: "u",
			Á: "a",
			É: "e",
			è: "e",
			Í: "i",
			Ó: "o",
			Ú: "u",
		},
		carrito: [],
		total: 0,
		mostrarCarro: false,
	},
	created() {
		this.cargarDatos()
	},

	methods: {
		cargarDatos() {
			axios
				.get("/api/prendas")
				.then((response) => {
					this.prendas = response.data
					this.cargarPrendasMarroquinería()
				})
				.catch((error) => {
					console.log(error)
				})
			axios.get("/api/carrito").then((response) => {
				this.carrito = response.data
				this.carrito.forEach((element) => {
					this.total += element.precio
				})
			})
		},

		cargarPrendasMarroquinería() {
			this.zapatos = this.prendas.filter((element) => element.tipoArticulo == "ZAPATOS")
		},
		agregarCarrito(nombrePrenda, cant, monto, montoTotal) {
			this.total += montoTotal
			axios.get("/api/carrito").then((response) => {
				this.carrito = response.data
			})
			axios
				.post(
					"/api/carrito",
					`nombrePrenda=${nombrePrenda}&cantidad=${cant}&monto=${monto}&montoTotal=${this.total}`
				)
				.then((response) => {
					Swal.fire({
						icon: "success",
						text: "Artículo agregado al carrito correctamente",
						timer: 1500,
					})
				})
		},
		agregarCarrito(nombrePrenda, cant, monto, montoTotal) {
			axios.get("/api/carrito").then((response) => {
				this.carrito = response.data
				this.carrito.forEach((element) => {
					this.total += element.precio
				})
			})
			axios
				.post(
					"/api/carrito",
					`nombrePrenda=${nombrePrenda}&cantidad=${cant}&monto=${monto}&montoTotal=${this.total}`
				)
				.then((response) => {
					Swal.fire({
						icon: "success",
						text: "Artículo agregado al carrito correctamente",
					})
					setTimeout(() => {
						window.location.reload()
					}, 1500)
				})
				.catch((error) => {
					this.total -= montoTotal
				})
		},
		vaciarCarrito() {
			axios.delete(`/api/carrito`).then((response) => {
				this.total = 0
				Swal.fire({
					icon: "info",
					text: "Se eliminaron los artículos del carrito correctamente",
				})
				setTimeout(() => {
					window.location.reload()
				}, 1500)
			})
		},
		mostrarCarrito() {
			if (this.mostrarCarro) this.mostrarCarro = false
			else this.mostrarCarro = true
		},
		comprar() {
			axios.delete(`/api/carrito`).then((response) => {
				this.total = 0
				Swal.fire({
					icon: "Success",
					text: "Compra realizada con éxito!",
				})
				setTimeout(() => {
					window.location.reload()
				}, 1500)
			})
		},
	},
	computed: {
		filtrarPrendas() {
			return this.zapatos.filter((prenda) =>
				prenda.nombrePrenda.toLowerCase().includes(this.buscador.toLowerCase())
			)
		},
	},
})
