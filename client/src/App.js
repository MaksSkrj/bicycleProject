import React from 'react';
import Bicycles from "./component/Bicycles";
import 'semantic-ui-css/semantic.min.css';
import './style/Styles.css';
import {Divider, Icon, Input, Button} from 'semantic-ui-react';
import {getTopFiveRes, getSearchRes, getAllRes} from './actions/BikeActions';


export default class App extends React.Component {

    constructor() {
        super();
        this.state = {
            arr: [],
            inputValue: "",
            bikes: [],
            currentPageName: ""
        }
    };

    componentDidMount() {
        // Creating topFive
        this.createTopFive();
    };

    createTopFive = () => {
        getTopFiveRes().then(res =>
            this.setState({
                bikes: res,
                currentPageName: "Top Five Bikes"
            }));
    };

    getAll = () => {
        getAllRes().then(res =>
        this.setState({
            bikes: res,
            currentPageName: "All Products"
        }));
    };

    search = () => {
        if (this.state.inputValue.length === 0) {
            this.createTopFive();
        }
        else if (this.state.inputValue.length < 2) {
            alert("Need more information about searching product")
        } else {
            getSearchRes(this.state.inputValue).then((res) => {
                if (res.length !== 0) {
                    this.setState({
                        bikes: res,
                        currentPageName: "Search result for: " + this.state.inputValue
                    })
                } else {
                    alert("Sorry there isn't any product that you searching")
                }
            })
        }
    };


    inputChange = (e) => {
        this.setState({
            inputValue: e.target.value
        })
    };

    render() {
        console.log("BLYA")
        return (
            <div className='app-div'>
                <div className='search-div'>
                    <div className='search'>
                        <Input className={'search-input'} icon={<Icon name='search' inverted circular link onClick={this.search}/>}
                               onChange={this.inputChange} placeholder='Search...'/>
                        <Button inverted className={'get-all-button'} onClick={this.getAll}>All products</Button>
                        <Button inverted className={'get-all-button'} onClick={this.createTopFive}>Top Five Bikes</Button>

                    </div>
                    <div>
                        <h2 className='bike-shop-name'> Vrum-Vrum Bikes</h2>
                    </div>
                </div>
                <div className={'h1div'}>
                    <div>
                        <h1 className={'h1-text'}>
                            {this.state.currentPageName}
                        </h1>
                        <Divider/>
                    </div>
                </div>
                <Bicycles bikes={this.state.bikes} key={this.state.bikes.id}/>
            </div>
        )
    };
}
