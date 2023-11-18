import 'bootstrap/dist/css/bootstrap.min.css';
import PropTypes from 'prop-types'
import { useEffect, useState } from 'react'
import { Table, Input, Button } from 'reactstrap';
import { Link } from 'react-router-dom';

function Authorview({authors, getOneAuthor, getAuthors, onDeleteAuthor}) {

  const [searchValue, setSearchValue] = useState('');

  const handleInputChange = (e) => {
    setSearchValue(e.target.value);
  };

  

  const handleSearch = () => {
    if (searchValue.trim() === '') {
      getAuthors();
    } else {
      getOneAuthor(searchValue);
    }
  };

  useEffect(() => {
    getAuthors();
  }, []);

  return (
    <>
    <div style={{
      display: 'flex', 
      justifyContent: 'space-between',
      marginBottom: '40px'
    }}>
      <Link to="/crear-autor">
        <Button style={{
          width: '150px'
        }} color="success" className="text-nowrap">Agregar autor</Button>
      </Link>
      <Link to="/libros-por-autor">
        <Button style={{
          width: '150px'
        }} color="success" className="text-nowrap">Libros por autor</Button>
      </Link>
    </div>
    <div class="row" style={{
      display: 'flex', 
      justifyContent: 'space-between',
      marginBottom: '20px'
    }}>
        <div class="col ml-2">
            <Input 
              type="text"
              value={searchValue}
              onChange={handleInputChange}
            />
        </div>
        <div class="col mr-2 d-flex" style={{
          display: 'flex', 
          justifyContent: 'flex-end'
        }}>
          <Button color="success" onClick={handleSearch}>Buscar</Button>
        </div>
    </div>
    <Table responsive bordered>
      <thead>
        <tr>
          <th>Id</th>
          <th>Nombre</th>
          <th>Nacionalidad</th>
        </tr>
      </thead>
      <tbody>
        {authors.map((author, index) => (
          <tr key={index}>
            <th scope="row">{author.id}</th>
            <td>{author.name}</td>
            <td>{author.nationality}</td>
            <td>
              <Button
                color="danger"
                onClick={() => onDeleteAuthor(author.id)}
              >
                Delete
              </Button>
            </td>
            <td>
              <Link to={{
                    pathname: `/autores/editar/${author.id}`,
                  }}>
                <Button color="success" >
                  Edit
                </Button>
              </Link>
            </td>
          </tr>
        ))}
      </tbody>
    </Table>
    </>
  )
}

Authorview.propTypes = {
  authors: PropTypes.array.isRequired,
  getOneAuthor: PropTypes.func.isRequired,
  getAuthors: PropTypes.func.isRequired,
  onDeleteAuthor: PropTypes.func.isRequired, 
  searchValue: PropTypes.string, 
};

export default Authorview
