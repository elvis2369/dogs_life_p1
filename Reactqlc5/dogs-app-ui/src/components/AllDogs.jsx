import React from 'react'
import DogDetail from './DogDetail'
import Row from 'react-bootstrap/Row'
import { useState } from 'react';
import { getAllDogs } from '../services/dog-service';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';


const AllDogs = () => {

    const [total, setTotal] = useState(0);
    const [dogs, setDogs] = useState([]);
    const navigate = useNavigate();

    const totalCountHandler = (name) =>{
      console.log(name)
      setTotal(total+1);
      }
      
      //QL-8
      useEffect(()=>{
        getDogsFromAPI();}, 
        []
        );
      const getDogsFromAPI = ()=>{

        getAllDogs()
        .then(res => {
            setDogs(res.data);
        })
          .catch(err => {
          setDogs([]);
          console.log(err);
        })
      }


      //QL-8

      return (
        <>
          <h1> Total count is: {total}</h1>
          <Row >
          {dogs.map(dog => (
            <div className='container' key={dog.id.toString()}>
              <DogDetail info={dog} parentCount={totalCountHandler} />
            </div>
           ))}
          </Row>
        </>
      )
}


export default AllDogs