
function initCursorEffect() {
    document.addEventListener("click", (e) => {
        const ripple = document.createElement("div");
        ripple.className = "ripple";
        document.body.appendChild(ripple);
        ripple.style.left = `${e.clientX}px`;
        ripple.style.top = `${e.clientY}px`;
        ripple.style.animation = `ripple-effect .4s  linear`;
        ripple.onanimationend = () => {
            document.body.removeChild(ripple);
        }
    });

    // const all = document.body.getElementsByTagName("*");
    // for (let i = 0;  i < all.length; ++i) {
    //     all[i].addEventListener("click", (e) => {
    //         e.stopPropagation();
    //     });
    // }
}

window.addEventListener('load', () => {
    initCursorEffect();
});

function pray() {
    const sortableItems = document.getElementsByTagName('a');
    const pray = document.querySelectorAll('.pray');
    for (const sortableItem of sortableItems) {
        if(sortableItem.matches(':hover')) {
            console.log("test")
            for (const pray2 of pray) {
                pray2.classList.toggle('d-none')
                console.log(pray2)
            }
        }
    }
}
window.addEventListener('mouseover', () => {
    pray();
});