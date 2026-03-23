/**
 * Interacción Vanilla JS para la Experiencia de Usuario (UX)
 * Componente: Auto-rastreo de la barra de navegación basada en Scroll (ScrollSpy O(1)) y Revelación Mágica.
 */

document.addEventListener("DOMContentLoaded", () => {
    
    // Nodos a interactuar
    const sections = document.querySelectorAll(".fade-in");
    const navLinks = document.querySelectorAll("#sidebar ul li a");

    // 1. Efecto Scroll Reveal (Aparición Gradual)
    const revealOptions = {
        threshold: 0.15,
        rootMargin: "0px 0px -50px 0px"
    };

    const revealOnScroll = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                // Al entrar en pantalla, inyectamos la clase transformadora CSS
                entry.target.classList.add("visible");
                observer.unobserve(entry.target); // Optimizar RAM, ignorar tras revelarse
            }
        });
    }, revealOptions);

    sections.forEach(card => revealOnScroll.observe(card));

    
    // 2. Rastreo de Menú Secuencial (ScrollSpy)
    const spyOptions = {
        threshold: 0.4, // Se activa cuando un 40% de la tarjeta invade la pantalla
        rootMargin: "0px 0px -100px 0px"
    };

    const navObserver = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                let currentId = entry.target.getAttribute("id");
                
                // Remueve 'active' de todos y mapea condicionalmente
                navLinks.forEach(link => {
                    link.classList.remove("active");
                    // Valida si el Href empata con el id que intersectó
                    if (link.getAttribute("href") === `#${currentId}`) {
                        link.classList.add("active");
                    }
                });
            }
        });
    }, spyOptions);

    // Adjuntar observador a todas las secciones que posean un Tag ID
    document.querySelectorAll("section[id]").forEach(sec => navObserver.observe(sec));

});
