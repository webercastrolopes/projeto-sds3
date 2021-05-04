import ImgDsDark from 'assets/img/ds-dark.svg';
/* .tsx é o arquivo typeScript aqui do React */

/* function NavBar() {    #forma normal de criar uma função#*/
const NavBar = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/
    return (
        <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-light border-bottom shadow-sm">
            <div className="container">
                <nav className="my-2 my-md-0 mr-md-3">
                    <img src={ImgDsDark} alt="DevSuperior" width="120" />
                </nav>
            </div>
        </div>
    );
}

// shift+alt+f para identar código
export default NavBar;
