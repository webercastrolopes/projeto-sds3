// .tsx é a extensão de componente de react para typeScript

const Footer = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/
    return (
        <footer className="footer mt-auto py-3 bg-dark">
            <div className="container">
                <p className="text-light">App desenvolvido por <a href="https://github.com/webercastrolopes" target="_blank" rel="noreferrer">Weber de Castro Lopes</a></p>
                <p className="text-light"><small><strong>Semana Spring React</strong><br />
      Evento promovido pela escola DevSuperior: <a href="https://instagram.com/devsuperior.ig" target="_blank" rel="noreferrer">@devsuperior.ig</a></small></p>
            </div>
        </footer>
    );
}

// shift+alt+f para identar código
export default Footer;