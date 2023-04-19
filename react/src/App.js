import React from 'react'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import SignIn from './components/signIn'
import Matieres from './components/etudiant/matieres'

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path='/' element={<SignIn />}/>
        <Route path='/matieres' element={<Matieres />}/>
      </Routes>
    </BrowserRouter>
      
  )
}

export default App