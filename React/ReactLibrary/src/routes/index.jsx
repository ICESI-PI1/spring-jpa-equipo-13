import {Route, Routes, BrowserRouter  } from  'react-router-dom';
import BookList from '../pages/BookList'
import AuthorList from '../pages/AuthorList'
import Login from '../pages/Login';
import CreateAuthorList from '../pages/CreateAuthorList';
import CreateBook from '../pages/CreateBook';
import BooksByAuthor from '../pages/BooksByAuthor';
import Choose from '../pages/Choose'
import EditAuthor from '../pages/EditAuthor';
import EditBook from '../pages/EditBook';

const  Router = () => (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Login />}/>
            <Route path="/libros" element={<BookList />}/>
            <Route path = "/libros/editar/:idBook" element={<EditBook/>}/>
            <Route path="/autores" element={<AuthorList/>}/>
            <Route path = "/autores/editar/:idAuthor" element={<EditAuthor/>}/>
            <Route path="/crear-autor" element={<CreateAuthorList/>}/>
            <Route path = "/crear-libro" element = {<CreateBook/>}/>
            <Route path = "/libros-por-autor" element = {<BooksByAuthor/>}/>
            <Route path = "/seleccionar" element={<Choose/>}/>   
        </Routes>
    </BrowserRouter>
)

export default Router