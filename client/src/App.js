import React from 'react';
import './style/Styles.css';
import axios from 'axios';
import Bicycles from "./component/Bicycles";
import Bike from "./component/Bike";
import 'semantic-ui-css/semantic.min.css';
import { Divider, Icon, Input} from 'semantic-ui-react'


class App extends React.Component {
    constructor() {
        super();
        this.state = {
            inputValue: "bla",
            arr: [],
            err: ""
        }
    }

    componentWillMount() {
        // Creating topFive
        this.createTopFive();
    }


    createTopFive = () => {
        axios
            .get('http://localhost:8080/bike/getTop')
            .then((res) => {
                let arr = [];
                console.log(res);
                res.data.forEach((item) => {
                    arr.push(<Bike data={item}/>)
                });
                this.setState({
                    arr: [],
                });
                this.setState({
                    arr: arr,
                });
            });
    };

    search = () => {
        if (this.state.inputValue.length < 2){
            alert("Need more information about searching product")
        }else {
            axios
                .get('http://localhost:8080/bike/search/' + this.state.inputValue)
                .then((res) => {
                    let arr = [];
                    console.log(res);
                    if (res.data.length !== 0) {
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
                    <div>
                        <h2 className='bike-shop-name'>Vrum-Vrum Bikes</h2>
                    </div>
                    <div className='search-input'>
                        <Input icon={<Icon name='search' inverted circular link onClick={this.search}/>} onChange={this.inputChange} placeholder='Search...' />
                    </div>
                </div>
                <div className={'h1div'}>
                    <div>
                        <h1 className={'h1-text'} onClick={this.createTopFive}>
                            Top five bikes
                        </h1>
                        <Divider />
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

