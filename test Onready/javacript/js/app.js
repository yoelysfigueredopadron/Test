// Creando la clase auto
class auto {
    constructor(marca, modelo, puertas, precio) {
      this.marca = marca;
      this.modelo = modelo;
      this.puertas = puertas;
      this.precio = precio;
    }
}

// Creando la clase moto
class moto {
constructor(marca, modelo, cilindrada, precio) {
    this.marca = marca;
    this.modelo = modelo;
    this.cilindrada = cilindrada;
    this.precio = precio;
    }
}

vehiculo1 = new auto("Peugeot", "206", 4, 200000);
vehiculo2 = new moto("Honda", "Titan", "125cc", 60000);
vehiculo3 = new auto("Peugeot", "208", 5, 250000);
vehiculo4 = new moto("Yamaha", "YBR", "160cc", 80500.50);

// creamos un arreglo con los vehiculos
const vehiculos = [vehiculo1, vehiculo2, vehiculo3, vehiculo4];
// console.log(vehiculos);

// asignamos el precio de vehiculo1 para tener un valor inicial para la condición al momento de comparar para buscar el vehiculo de mayor o menor precio
let mayorPrecio = vehiculo1.precio;
let menorPrecio = vehiculo1.precio;
let vehiculoMasCaro;
let vehiculoMasBarato;
let ModeloY;
let textoDOM1;
let textoDOM2;
let textoDOM3;

// creamos una expresión regular para realizar la búsqueda del vehículo que contenga 'Y' sin importar si es mayúscula o minúscula
let patron = /y/i;

// creamos los registros que mostraremos en el DOM
const registro1 = "Marca: " + vehiculo1.marca + " // Modelo: " + vehiculo1.modelo + " // Puertas: " + vehiculo1.puertas + " // precio: " + formatoMoneda(vehiculo1.precio);
const registro2 = "Marca: " + vehiculo2.marca + " // Modelo: " + vehiculo2.modelo + " // Puertas: " + vehiculo2.cilindrada + " // precio: " + formatoMoneda(vehiculo2.precio);
const registro3 = "Marca: " + vehiculo3.marca + " // Modelo: " + vehiculo3.modelo + " // Puertas: " + vehiculo3.puertas + " // precio: " + formatoMoneda(vehiculo3.precio);
const registro4 = "Marca: " + vehiculo4.marca + " // Modelo: " + vehiculo4.modelo + " // Puertas: " + vehiculo4.cilindrada + " // precio: " + formatoMoneda(vehiculo4.precio);

// creamos un arreglo de los registros de vehículos
// const registros = [registro1, registro2, registro3, registro4];
const registros = [];
registros[0] = registro1;
registros[1] = registro2;
registros[2] = registro3;
registros[3] = registro4;

// Buscamos el vehiculo de mayor y menor precio
for (let i = 0; i < vehiculos.length; i++) {
    if (mayorPrecio < vehiculos[i].precio) {
        mayorPrecio = vehiculos[i].precio;
        vehiculoMasCaro = `Vehículo más caro: ${vehiculos[i].marca} ${vehiculos[i].modelo}`;
    }

    if (menorPrecio > vehiculos[i].precio) {
        menorPrecio = vehiculos[i].precio;
        vehiculoMasBarato = `Vehículo más barato: ${vehiculos[i].marca} ${vehiculos[i].modelo}`;
    }

    if (vehiculos[i].modelo.search(patron) !== -1) {
        ModeloY = `Vehículo que contiene en el modelo la letra ‘Y’: ${vehiculos[i].marca} ${vehiculos[i].modelo} $${vehiculos[i].precio}`;
    }
}

// Mostramos los registros en consola con un for
// for (let i = 0; i < registros.length; i++) {
//     console.log(`${i + 1}- ${registros[i]}`);
// }

console.log("Informe:");
console.log("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
// Mostramos los registros en consola con un forEach
registros.forEach((registro, i) => console.log(`${i + 1}- ${registro}`));
console.log("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
console.log("* ", vehiculoMasCaro);
console.log("* ", vehiculoMasBarato);
console.log("* ", ModeloY);
console.log("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

// console.log( vehiculos.sort(function(a, b){return a.precio - b.precio}));  // ordenado ascendente
// console.log( vehiculos.sort(function(a, b){return b.precio - a.precio}));  // ordenado descendente

// Mostramos los registros en consola con un forEach de vehículos ordenados por precio de mayor a menor:
const ordenDescendente = vehiculos.sort(function(a, b){return b.precio - a.precio});
console.log("Vehículos ordenados por precio de mayor a menor:");
ordenDescendente.forEach((registro, i) => console.log(`${i + 1}- ${registro.marca} ${registro.modelo}`));

// Mostramos el resultado en el DOM
textoDOM1 = "<ol>";
registros.forEach(mostrarInfo);
textoDOM1 += "</ol>";
document.getElementById("contenido1").innerHTML = textoDOM1;

textoDOM2 = "<ul>" + "<li>" + vehiculoMasCaro + "</li>" + "<li>" + vehiculoMasBarato + "</li>" + "<li>" + ModeloY + "</li>" + "</ul>";
document.getElementById("contenido2").innerHTML = textoDOM2;

textoDOM3 = "<ol>";
for (i = 0; i < ordenDescendente.length; i++) {
    textoDOM3 += "<li>" + ordenDescendente[i].marca + " " + ordenDescendente[i].modelo + "</li>";
}
textoDOM3 += "</ol>";
document.getElementById("contenido3").innerHTML = textoDOM3;

function mostrarInfo(registro) {
  textoDOM1 += "<li>" + registro + "</li>";
}

function formatoMoneda(precio) {
    return new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(precio);
}