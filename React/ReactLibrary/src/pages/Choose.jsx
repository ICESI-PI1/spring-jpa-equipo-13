import 'bootstrap/dist/css/bootstrap.min.css';
import PropTypes from 'prop-types'
import {Card,CardBody,CardTitle,CardSubtitle, CardText, Button} from 'reactstrap'
import { Link } from 'react-router-dom';
import Libros from '../img/libros.png'
import Autores from '../img/Gabo.jpg'

function Choose(){
    return (
        <div className="d-flex flex-row flex-wrap">
          <div className="col col-sm-6 col-md-4 mb-2 mx-5">
            <Card inverse style={{ width: '18rem' }} className="mb-2">
              <img alt="Sample" src={Libros}  />
              <CardBody>
                <CardTitle tag="h5">Card title</CardTitle>
                <CardSubtitle className="mb-2 text-muted" tag="h6">
                  Libros
                </CardSubtitle>
                <CardText>
                  Some quick example text to build on the card title and make up the bulk of the card's content.
                </CardText>
                <Link to="/libros">
                <Button style={{
                  backgroundColor: 'blue',
                  color: 'white',
                  padding: '10px 20px',
                  border: 'none',
                  borderRadius: '5px',
                  width: '100%'
                }}
                > Ir a libros</Button>
                </Link>
              </CardBody>
            </Card>
          </div>
      
          <div className="col col-sm-6 col-md-4 mb-2 mx-5">
            <Card inverse style={{ width: '18rem' }} className="mb-2">
              <img alt="Sample" src={Autores} />
              <CardBody>
                <CardTitle tag="h5">Card title</CardTitle>
                <CardSubtitle className="mb-2 text-muted" tag="h6">
                  Autores
                </CardSubtitle>
                <CardText>
                  Some quick example text to build on the card title and make up the bulk of the card's content.
                </CardText>
                <Link to="/autores">
                <Button style={{
                  backgroundColor: 'blue',
                  color: 'white',
                  padding: '10px 20px',
                  border: 'none',
                  borderRadius: '5px',
                  width: '100%'
                }}
                
                >Ir a autores</Button>
                </Link>
              </CardBody>
            </Card>
          </div>
        </div>
      );
      
      
      
      
      
      
}

export default Choose