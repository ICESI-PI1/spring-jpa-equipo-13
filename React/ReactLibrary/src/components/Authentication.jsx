import React from 'react'
import { useEffect, useState } from 'react'
import { Form, FormGroup, Button, Label, Input, FormText} from 'reactstrap'
import PropTypes from 'prop-types'
import axios from  '../config/axios'
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


const Authentication = ({userEdit}) => {

  

  const[username, setUsername]=useState('')
  const[password, setPassword]= useState('')

  const buttonStyle = {
    backgroundColor: 'blue',
    color: 'white',
    padding: '10px 20px',
    border: 'none',
    borderRadius: '5px',
    width: '100%'
};
  
    useEffect(()=>{
        setUsername(userEdit.username)
        setPassword(userEdit.password)
    }, [userEdit])

    let user = {username, password};
    let navigate = useNavigate(); // Obtén la función navigate

  const handleClick = () => {
    axios.post("/authenticate", user)
      .then(res => {
        if(res.status === 200 ) {
          localStorage.setItem("token", res.data.token);
          navigate('/seleccionar'); // Navega a la ruta deseada
        }
        console.log(res);
      }).catch(err => {
        alert("¡La contraseña ingresada esta mala!")
        console.log(err);
      });
  }

  return (
    <div>
      <h1>Login</h1>
      <Form>
        <FormGroup>
          <Label for="exampleUsername" style={{
            display:'flex'
          }}> Usuario </Label>
          <Input id="exampleUsername" name="username" placeholder="Usuario" type="text" onChange={(e)=>{setUsername(e.target.value)}} />
        </FormGroup>
        {' '}
        <FormGroup>
          <Label for="examplePassword" style={{
            display:'flex'
          }} > Contraseña </Label>
          <Input id="examplePassword" name="password" placeholder="Contraseña" type="password" onChange={(e)=>{setPassword(e.target.value)}} />
        </FormGroup>
        {' '}
        <Button onClick={handleClick} style={buttonStyle}>
          Submit
        </Button>
      </Form> 
    </div>
  )
}

Authentication.propTypes = {
  loginUser: PropTypes.func, 
  userEdit:PropTypes.object
}

export default Authentication