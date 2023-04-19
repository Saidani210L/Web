import React, { useState, useEffect } from 'react'
import '../../styles/matieres.css'

const Matieres = () => {
  
  const [absences, setAbsences] = useState([])

  const render = (data) =>{
    const tableBody = document.getElementById('tableBody')
    tableBody.innerHTML = ''
    data.forEach((absence =>{
      const tr = document.createElement('tr')
      const td1 = document.createElement('td')
      const td2 = document.createElement('td')
      const td3 = document.createElement('td')
      const button = document.createElement('button')
      td1.innerHTML = absence.matiere.nomMatiere
      td2.innerHTML = absence.nbAbsence
      button.innerHTML = 'Detail'
      td3.appendChild(button)
      tr.appendChild(td1)
      tr.appendChild(td2)
      tr.appendChild(td3)
      tableBody.appendChild(tr)
    }))
  }

  useEffect(() => {
    render(absences)
  }, [absences])
  
  useEffect(() => {
      fetch(`http://localhost:8080/absences/etudiant/${1}/matieres`)
      .then(res => res.json())
      .then(result => setAbsences(result))
  }, [])

  const search = (e)=>{
    let regex = new RegExp(`^${e.target.value}.*$`)
    let updatedAbsences = absences.filter((element)=>{
      return regex.test(element.matiere.nomMatiere)
      
    })
    if(e.target.value === ''){
      render(absences)
    }else render(updatedAbsences) 
  }

console.log(absences)
  return(
    <div className='table'>
      <div className='table_header'>
        <p>Matieres</p>
        <div>
          <input placeholder='matiere' onChange={(e)=>search(e)}/>
        </div>
      </div>
      <div className='table_section'>
        <table>
          <thead>
            <tr>
              <th>Matiere</th>
              <th>Absences</th>
              <th>Options</th>
            </tr>
          </thead>
          <tbody id='tableBody'>
          </tbody>
        </table>
      </div>
    </div>
  )
  }


export default Matieres

/*<tr>
              <td>Web</td>
              <td>2</td>
              <td>
                <button>Detail</button>
              </td>
            </tr>*/