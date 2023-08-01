import React, {useState} from 'react'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Button from 'react-bootstrap/Button'
const HeroForm = () => {

  const [alias, setAlias] = useState('');
  const [name, setName] = useState('');
  const [ability, setAbility] = useState('');
  const [teamID, setTeamID] = useState(0);

  const handleAlias = (event) =>{
    setAlias(event.target.value);
  }

  const handleName = (event) =>{
    setName(event.target.value);
  }

  const handleAbility = (event) =>{
    setAbility(event.target.value);
  }

  const handleTeam = (event) =>{
    setTeamID(event.target.value);
  }

  const onHandleSubmit = (event) =>{
    event.preventDefault();
    let hero = {};
    hero.alias = alias;
    hero.name = name;
    hero.ability = ability;
    hero.teamID = teamID;
    console.log(hero);
  }

  return (
    <Row className='heroForm'>
      <Form>
        <Form.Group className="mb-3" controlId='alias'>
          <Form.Label>Hero Alias:</Form.Label>
          <Form.Control type="text" placeholder='Hero alias' value={alias} onChange={handleAlias}/>
        </Form.Group>
        <Form.Group className="mb-3" controlId='name'>
          <Form.Label>Hero Name:</Form.Label>
          <Form.Control type="text" placeholder='Hero name' value={name} onChange={handleName}/>
        </Form.Group>
        <Form.Group className="mb-3" controlId='ability' value={ability} onChange={handleAbility}>
          <Form.Label>Hero Ability:</Form.Label>
          <Form.Control type="text" placeholder='Hero ability'/>
        </Form.Group>
        <Form.Select aria-label='Team ID' value={teamID} onChange={handleTeam}>
          <option value={1}>One</option>
          <option value={2}>Two</option>
          <option value={3}>Three</option>
        </Form.Select>
        <Button onClick={onHandleSubmit} variant="primary" type="submit" >Submit</Button>
      </Form>
    </Row>
  );
}

export default HeroForm