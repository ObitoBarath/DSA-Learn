const school  = {
    student1 : "Imran",
    student2 : "Nandhakumar"
}

class Singleton {


    constructor() {

        if (!Singleton.instance){
            Singleton.instance = this;
        }
        return Singleton.instance;

    }
}

const securityGuard = new Proxy(school  , {
    get(target, property, receiver) {
        console.log("target ==>" , target)
        console.log("p ==>" , property)
        if (property in target){
                return `Welcome ${target[property]}`
        }else
            return "Access Denied";
    },
    deleteProperty(target, property) {


        if (property === "student1"){
            return "not-allowed"
        }else {
            delete target[property];
        }

    }
})


console.log(securityGuard.teacher)
console.log( delete securityGuard.student1)



const admission = new Proxy({} , {
    set(target, property    , newValue, receiver) {
            if (property === "age" && newValue < 18){
                console.error("Too young ")
                return false;
            }else {
                target[property] = newValue;
                return true;
            }
    }
})



admission.age = 10;
console.log("10 admission ==>" ,admission)
admission.age = 20;
console.log("20 admission ==>" ,admission)




const animal = {
    speak(){
        console.log("Naan thaan da LEO ")
    }
}

hello()
function hello(){
    (function (){
        console.log("IIFE" , arguments)
    })();
}

let animalObject = Object.create(animal);
animal.speak();
animalObject.speak();


const singleton1 = new Singleton();
const singleton2 = new Singleton();

const s1 =  "5"
const s2 = 5


console.log(s1 === s2)



function Person({name = "" , age = ""}  = {}){
    this.name = name;
    this.age = age;
}


const person = new Person({name  : "Keerthana" , age : 12})

console.log("person ==>" , person)


Person.prototype.name = "Barath"

const newPerson = new Person();

console.log("newPerson ==>" , newPerson)




const curryFunction = a => b => c=> d => {
    console.log(a,b,c,d)
}
curryFunction("a")("b")("c")("d")


let x = 1;


switch (x) {
    case 0:{
        let name;
        break;
    }


    case 1:
        let name; // SyntaxError for redeclaration.
        break;
}

var message;
console.log(message);
message = "The variable Has been hoisted";








var a =100;

{
    let a = 500
}

var b = a;
{
    var b = 200
}
let c = b-a;
console.log("c ==>" , c)

