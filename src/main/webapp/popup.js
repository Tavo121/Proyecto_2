var btnopen = document.getElementById('btn-open'),
    overlay = document.getElementById('overlay'),
    popup = document.getElementById('popup'),
    btnclose = document.getElementById('btn-close');

btnopen.addEventListener('click', function() {
    overlay.classList.add('active')
    popup.classList.add('active')
});

btnclose.addEventListener('click', function() {
    overlay.classList.remove('active');
    popup.classList.remove('active')
});

