import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import { Route, Routes } from 'react-router-dom';
import AllHeroes from './/components/AllHeroes';  
import HeroForm from './/components/HeroForm';
function App() {
  return (

    <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
      <Navbar.Brand href="/">Heroes</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="me-auto">
      <Nav.Link href="/allheroes">All Heroes</Nav.Link>
      <Nav.Link href="/heroform">Add Hero</Nav.Link>
      </Nav>        
      </Navbar.Collapse>
      </Container>
    </Navbar>
    <Routes>
      <Route path="/allheroes" element={<AllHeroes/>}/>
      <Route path="heroform" element={<HeroForm/>} />
      <Route path="/" element={<AllHeroes/>} />
    </Routes>

</>
  );
}

export default App;