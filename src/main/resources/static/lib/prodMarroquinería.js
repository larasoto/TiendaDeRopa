var app = new Vue({
	el: "#app",
	data: {
		prendas: [],
		prendasMarroquineria: [],
		buscar: "",
		setTimeoutBuscador: "",
		carrito: [],
		total: 0,
		mostrarCarro: false,
	},
	created() {
		this.cargarDatos()
	},

	methods: {
		cargarDatos() {
			axios.get("/api/carrito").then((response) => {
				this.carrito = response.data
				this.carrito.forEach((element) => {
					this.total += element.precio
					// if(this.carrito.nombrePrenda && this.carrito.precio)
				})
				// for (var i = 0; i < this.carrito.length; i++) {
				// 	for (var j = 0; j < this.carrito.length - 1; i++) {
				// 		if (this.carrito[i].nombrePrenda == this.carrito[j].nombrePrenda) {
				// 			axios.delete(`/api/carrito/${j}`)
				// 			.then(function (response) {
				// 				this.carr
				// 			})
				// 		}
				// 	}
				// }
			})
			axios
				.get("/api/prendas")
				.then((response) => {
					this.prendas = response.data
					this.cargarPrendasMarroquineria()
				})
				.catch((error) => {
					console.log(error)
				})
		},

		cargarPrendasMarroquineria() {
			this.prendasMarroquineria = this.prendas.filter(
				(element) => element.tipoArticulo == "MARROQUINERIA"
			)
		},
		cargarPrendasMarroquineria() {
			this.prendasMarroquineria = this.prendas.filter(
				(element) => element.tipoArticulo == "MARROQUINERIA"
			)
		},
		filtroCategorias(categoria) {
			this.prendasMarroquineria = this.prendasMarroquineria.filter((element) =>
				element.nombrePrenda.includes(categoria)
			)
		},
		filtroPrecio(precioDesde, precioHasta) {
			this.prendasMarroquineria.forEach((precio) => {
				if (
					this.prendasMarroquineria.precio >= precioDesde &&
					this.prendasMarroquineria.precio <= precioHasta
				) {
					this.filterPrecio.push(precio)
				} else {
					this.filterPrecio = []
				}
			})
		},
		filtroColor(color) {
			this.prendasMarroquineria = this.prendasMarroquineria.filter((element) =>
				element.nombrePrenda.includes(color)
			)
		},
		buscadorr() {
			this.prendasMarroquineria.forEach((element) => {
				if (
					element.nombrePrenda.toLowerCase().includes(element.nombrePrenda.toLowerCase()) ||
					this.buscar == ""
				) {
					this.prendasMarroquineria = this.prendasMarroquineria.filter((elemento) =>
						elemento.nombrePrenda.toLowerCase().includes(this.buscar.toLowerCase())
					)
				}
			})
		},
		agregarCarrito(nombrePrenda, cant, monto, montoTotal) {
			axios.get("/api/carrito").then((response) => {
				this.carrito = response.data
				this.carrito.forEach((element) => {
					this.total += element.precio
				})
				// this.total += montoTotal
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
			return this.prendasMarroquineria.filter((prenda) =>
				prenda.nombrePrenda.toLowerCase().includes(this.buscar.toLowerCase())
			)
		},
	},
})
