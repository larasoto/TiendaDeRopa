var app = new Vue({
	el: "#app",
	data: {
		nombre: "",
		apellido: "",
		email: "",
		contraseña: "",
		registrado: false,
	},
	methods: {
		login() {
			axios
				.post("/api/login", "email=" + this.email + "&password=" + this.contraseña)
				.then((response) => {
					if (!this.registrado) {
						Swal.fire({
							icon: "success",
							title: "Excelente",
							text: "Usted ha iniciado sesión correctamente",
							timer: 1500,
						}).then(() => {
							window.location.href = "web/zapatos.html"
						})
					} else {
						window.location.href = "web/zapatos.html"
					}
				})
				.catch((error) => {
					console.log(error)
				})
		},
		register() {
			/*axios.post('https://eco-banking.herokuapp.com/api/clients', "photo=../Client.png" + "firstName="+this.nombre+"&lastName="+this.apellido+"&email="+this.email+"&password="+this.contraseña, { headers: { "content-type": "application/x-www-form-urlencoded" } })
		    .then(response=> {*/
			axios
				.post(
					"/api/clientes",
					"nombre=" +
						this.nombre +
						"&apellido=" +
						this.apellido +
						"&email=" +
						this.email +
						"&password=" +
						this.contraseña,
					{ headers: { "content-type": "application/x-www-form-urlencoded" } }
				)
				.then((response) => {
					Swal.fire({
						icon: "success",
						title: "Excelente",
						text: "Usted se ha registrado con éxito",
						timer: 1500,
					}).then(() => {
						this.registrado = true
						this.login()
					})
				})
				.catch((error) => {
					console.log(error)
				})
			//			    })
		},
	},
})

const signUpButton = document.getElementById("signUp")
const signInButton = document.getElementById("signIn")
const container = document.getElementById("container")

signUpButton.addEventListener("click", () => {
	container.classList.add("right-panel-active")
})

signInButton.addEventListener("click", () => {
	container.classList.remove("right-panel-active")
})
