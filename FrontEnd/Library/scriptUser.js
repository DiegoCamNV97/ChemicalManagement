function setTitle(title) {
    document.getElementById('navbarTitle').textContent = title;
    var items = document.querySelectorAll('.nav-link');
    items.forEach(item => {
        item.classList.remove('active');
        if (item.textContent === title) {
            item.classList.add('active');
        }
    });
}