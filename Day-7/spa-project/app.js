function loadPage(page) {
    const content = document.getElementById("content");

    if (page === "home") {
        content.innerHTML = `<h1>Welcome to Home</h1><p>This is the home section.</p>`;
    } else if (page === "about") {
        content.innerHTML = `<h1>About Us</h1><p>This SPA is built with HTML, CSS, and JavaScript.</p>`;
    } else if (page === "contact") {
        content.innerHTML = `<h1>Contact</h1><p>Email us at contact@example.com</p>`;
    }
}


window.onload = () => loadPage("home");
