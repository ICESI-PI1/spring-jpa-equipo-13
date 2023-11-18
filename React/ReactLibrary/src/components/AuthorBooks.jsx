import React from 'react';
import PropTypes from 'prop-types'
import { useEffect, useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table, Input, Button } from 'reactstrap';

function AuthorBooks({authors, getAuthorBooks}) {

    const [searchValue, setSearchValue] = useState('');
    const handleInputChange = (e) => {
        setSearchValue(e.target.value);
    };

    const handleSearch = () => {
        getAuthorBooks(searchValue)
    };
  return (
    
        <div>
          <h1 style={{
            marginBottom: '50px'
          }} >Buscar Libros por Autor</h1>
          <div style={{
            display: 'flex', 
            flex: 'flex-wrap'
          }}>
            <Input
              type="text"
              placeholder="ID del autor"
              value={searchValue}
              onChange={handleInputChange}
              style={{
                marginRight: '40px'
              }}
            />
            <Button color='success' onClick={handleSearch}>Buscar</Button>
          </div>
           {(
            <Table>
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Título</th>
                </tr>
              </thead>
              <tbody>
                {authors.map((book) => (
                  <tr key={book.id}>
                    <td>{book.id}</td>
                    <td>{book.title}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
          )}
        </div>
      );
    
  
}

AuthorBooks.propTypes = {
    books: PropTypes.array.isRequired,
    getAuthorBooks: PropTypes.func.isRequired,
    searchValue: PropTypes.string, 
  };

export default AuthorBooks;
