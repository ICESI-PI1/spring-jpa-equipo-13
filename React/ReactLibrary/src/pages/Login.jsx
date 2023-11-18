import React from 'react'
import { useEffect, useState } from 'react'
import Authentication from '../components/Authentication'
import axios from  '../config/axios'
import { bookcontext } from '../context/bookcontext'


const Login = () => {

    const[userEdit, setUserEdit]= useState({id:"", password:""})

    const loginUser = async (user) => {
        try {
         
        } catch (e) {
          console.log(e);
        }
      };

  return (
    <bookcontext.Provider>
          <Authentication userEdit={setUserEdit}/>
    </bookcontext.Provider>
  )
}

export default Login  