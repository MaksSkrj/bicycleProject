import React from 'react';
import './style/Styles.css';
import axios from 'axios';
import Bicycles from "./component/Bicycles";
import Bike from "./component/Bike"


class App extends React.Component {
    constructor() {
        super();
        this.state = {
            inputValue: "bla",
            arr: [],
            err: ""
        }
    }

    componentDidMount() {
        // Creating topFive
        this.setState({
            arr: []
        });
        axios
            .get('http://localhost:8080/bike/getTop')
            .then((res) => {
                let arr = [];
                console.log(res);
                res.data.forEach((item) => {
                    arr.push(<Bike data={item}/>)
                });
                this.setState({
                    arr: arr
                })
            });

    }

    search = () => {
        if (this.state.inputValue.length < 2){
            alert("Need more information about searching product")
        }else {
            axios
                .get('http://localhost:8080/bike/search/' + this.state.inputValue)
                .then((res) => {
                    let arr = [];
                    console.log(res);
                    if (this.state.arr.length !== 0) {
                        res.data.forEach((item) => {
                            arr.push(<Bike data={item}/>)
                        });
                        this.setState({
                            arr: []
                        });
                        this.setState({
                            arr: arr
                        })
                    } else {
                        alert("Sorry there isn't any product that you searching")
                    }
                });
        }
    };

    inputChange = (e) => {
        this.setState({
            inputValue: e.target.value
        })
    };

    render() {
        return (
            <div className='app-div'>
                <div className='search-div'>
                    <div className='bike-shop-name'>
                        Vrum-Vrum Bikes
                    </div>
                    <div className='search-input'>
                        <input className='search' placeholder={"Search"} type="text" onChange={this.inputChange}/>
                        <input className={'search-button'} type="submit" value="Submit" onClick={this.search}/>
                    </div>
                </div>
                <div className={'h1div'}>
                    <div>
                        <h1 className={'h1-text'} onClick={this.componentDidMount}>
                            Top five bikes
                        </h1>
                    </div>
                </div>
                <div className={'bike-table'}>
                    <Bicycles arr={this.state.arr}/>
                </div>
            </div>
        )
    }
}

export default App;

