import React, { Component } from 'react';
import './App.css';
import {Doughnut} from 'react-chartjs-2';


class App extends Component {

  constructor(props){
    super(props)
    this.state = {
      data:{
        labels: [],
        datasets: [{
          data: [],
          backgroundColor: [],
          hoverBackgroundColor: []
        }]
      } 
    }
  }
  
  componentDidMount(){
    console.log('werkt dit?')
    fetch('http://localhost:8080/month?month=7')
      .then(response => {return response.json()})
      .then(monthJson => {
        var graphData = {
          labels: [],
          datasets: [{
            data: [],
            backgroundColor: [],
            hoverBackgroundColor: []
          }]
        } 

        monthJson.forEach((item, idx) => {          
          graphData.labels.push(item.label)
          graphData.datasets[0].data.push(item.value)
          graphData.datasets[0].backgroundColor.push(item.color)
        })

        this.setState({data:graphData})

      })
  }

  render() {
    return (
      <Doughnut data={this.state.data}/>
    );
  }
}

export default App;
