import Datatable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";


function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">Olá mundo !!</h1>

        <Datatable />
      </div>
      <Footer />
    </>
  );
}

/*
    <div>
      <h1 className="text-primary">Olá mundo</h1>
      <NavBar />
    </div>
*/

export default App;
