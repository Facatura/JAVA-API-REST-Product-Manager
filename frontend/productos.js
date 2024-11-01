///variables globales
const elements = {
    productoID: document.getElementById("productoID"),
    productoTamanio: document.getElementById("tamanioSelect"),
    productoSave: document.getElementById("productoSave"),
    verLista: document.getElementById('productoLista'),
    productotipoCafe: document.getElementById('tipoCafeSelect'),
    productoPrecio: document.getElementById('productoPrecio'),
    productoInventario: document.getElementById('productoInventario'),
};

//arreglo para guardar los datos del backend
let productos = [];
let tamanios = [];
let tiposDeCafe = [];

//constante para almacenar el url
const PRODUCTOS_URL = "http://localhost:8080/api/v1/productos";
const TIPOSDECAFE_URL = "http://localhost:8080/api/v1/tiposDeCafe";
const TAMANIOS_URL = "http://localhost:8080/api/v1/tamanios";

//al cargar el document, ejecutamos el getAll
document.addEventListener("DOMContentLoaded", ()=>{
    getAllProductos();
    
    loadTiposCafe();
    loadTamanios();
})

const getAllProductos = async() =>{
    try{
        const response = await fetch(PRODUCTOS_URL);

        if(!response.ok){
            throw Error("Error al solicitar los datos ${response.statusText}")
        }

        const data = await response.json();
        productos = data;
        console.log(productos);
    } catch(error){
        console.log("Error ${error.message}");
    }

    


}


elements.productoSave.addEventListener("click", (e) => {
    e.preventDefault();
    console.log(elements.values);
    const producto = {
        id: elements.productoID.value,
        precio: elements.productoPrecio.value,
        tipoCafe: elements.productotipoCafe.value,
        tamanio: elements.productoTamanio.value,
        inventario: elements.productoInventario.value
    };

    producto.id ? updateProductos(producto) : addProductos(producto);
})

elements.verLista.addEventListener("click", (e) => {
    e.preventDefault();
    getAllProductos();
    
    
})


const updateProductos = producto => {
    console.log("actualizando existente");
    console.log(producto);
}


   
const addProductos = async producto => {
    console.log("creando");
  try{

    const response = await fetch(PRODUCTOS_URL, {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(producto)
    });

    if(!response.ok){
        throw Error(`Error al registrar un producto: ${response.statusText}`)
    }

    alert(`Estudiante agregado exitosamente!!!`)
    getAllProductos();
   // formReset();

  } catch(error){
    console.log(`Error: ${error.message}`)
  }

}




/*Esta funcion corre el selector de los tipos de cafe, consulta el url de la DB, crea el select y hace el foreach para guardar cada elemento (cabe aclarar que por defecto sabe sus ID, pero yo puse que en opcionCafe.value devuelva el noombre en vez del numero, solo por capricho)*/ 
async function loadTiposCafe() {
    try {
        const response = await fetch(TIPOSDECAFE_URL);
        const tiposCafe = await response.json();

        const selectElement = document.getElementById('tipoCafeSelect');
        tiposCafe.forEach(tipoCafe => {
            const opcionCafe = document.createElement('option');
            opcionCafe.value = tipoCafe.nombre; // Usando el ID del tipo de café
            opcionCafe.textContent = tipoCafe.nombre; // Usando el nombre del tipo de café
            selectElement.appendChild(opcionCafe);
            console.log(opcionCafe);
        });
    } catch (error) {
        alert('Error mostrando los tipos de café:', error);
    }
}

/*Lo mismo pero para los tamaños*/
async function loadTamanios() {
    try {
        const response = await fetch(TAMANIOS_URL);
        const tamanios = await response.json();

        const selectElement = document.getElementById('tamanioSelect');
        tamanios.forEach(tamanio => {
            const opcionTamanio = document.createElement('option');
            opcionTamanio.value = tamanio.nombre; // Usando el ID del tipo de café
            opcionTamanio.textContent = tamanio.nombre; // Usando el nombre del tipo de café
            selectElement.appendChild(opcionTamanio);
            console.log(opcionTamanio);
        });
    } catch (error) {
        alert('Error mostrando los tamaños:', error);
    }
}



