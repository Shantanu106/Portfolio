window.addEventListener('load', function () {

    const loader = document.querySelector('.loader-wrapper');

    setTimeout(() => {
        loader.style.opacity = '0';

        setTimeout(() => {
            loader.style.display = 'none';
        }, 500);

    }, 800);

});
