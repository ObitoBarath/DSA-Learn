


(function Main() {

    console.log("Hello World!");

    x = 10;

    const obj = {
        name: "helo",
        value: "2",
    }


    let proxy = new Proxy(obj, {
        get(target, key) {
            console.log("target ", target)
            console.log("key", key)
            return target[key] + "vanakam da "
        }
    });



    console.log(proxy["name"])
    console.log("a ==>" , a)

    var a = 111;
    a ==1 ? strictMethod() : void(123)

    let wMap = new WeakMap();
    wMap.set(proxy , "b")
    console.log("wMap ==>" , wMap);

    console.log("=== call === ")
    strictMethod.call("HELLO")
    console.log("=== apply === ")
    strictMethod.apply("HELLO" , {})
    // strictMethod.bind()
    function* generator() {
        yield 1;
    }

    let gen = generator();
    let value = gen.next().value;


    console.log("gene =>", value);
    // pro


})()



function debounce(func, delay) {
    let timer;
    return function (...args) {
        clearTimeout(timer);
        timer = setTimeout(() => {
            func.apply(this, args);
        }, delay);
    };
}

// Usage
const onInputChange = debounce((event) => {
    console.log("Input value:", event.target.value);
}, 300);


/*document.addEventListener("DOMContentLoaded", function() {
    console.log("DOM is ready using native JavaScript!");
    document.querySelector("#search").addEventListener("input", onInputChange);


    function throttle(func, limit) {
        let lastCall = 0;
        return function (...args) {
            const now = Date.now();
            if (now - lastCall >= limit) {
                lastCall = now;
                func.apply(this, args);
            }
        };
    }

// Usage
    const onScroll = throttle(() => {
        console.log("Scroll event triggered!");
    }, 200);

    window.addEventListener("scroll", onScroll);


    function* generator(){
        yield "1"
        yield "2"
        yield "3"
        yield "4"
        yield "5"
    }

    console.log(generator())
    console.log(generator())
    console.log(generator())

});*/




"use-strict"
function strictMethod(...string){


    console.log("string ==>"  , string)
    console.log(" this ===>" , this)
}


/*
*


Hi Puneet Nanda sir,

I hope you’re doing well! I recently applied for a position at Verizon and shared the additional information requested last week. I noticed your profile here on LinkedIn and thought it would be a great opportunity to connect.

I’m very excited about the opportunity to join your team and contribute with my skills in [Key Skills]. Please feel free to let me know if there’s any additional information I can provide to assist in the process.

Looking forward to staying connected!

Best regards,
[Your Name]
*
*
* */
