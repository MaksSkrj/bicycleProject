import React from 'react';
import Bicycles from "./component/Bicycles";
import 'semantic-ui-css/semantic.min.css';
import './style/Styles.css';
import {Divider, Icon, Input, Button} from 'semantic-ui-react';
import {getTopFiveRes, getSearchRes, getAllRes} from './actions/BikeActions';
import NewProductModal from './component/NewProductModal'


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
        this.cleanStates();
        getTopFiveRes().then(res =>
            this.setState({
                bikes: res,
                currentPageName: "Top Five Bikes"
            }));
    };

    getAll = () => {
        this.cleanStates();
        getAllRes().then((res) =>
            this.setState({
                bikes: res,
                currentPageName: "All Products"
            }));
    };

    //TODO fix this
    cleanStates = () => {
        this.setState({
            bikes: []
        })
    };

    search = () => {
        this.cleanStates();
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
        return (
            <div className='app-div'>
                <div className='search-div'>
                    <div>
                        <h2 className='bike-shop-name'> Vrum-Vrum Bikes</h2>
                    </div>
                    <div className='search'>
                        <Input className={'search-input'}
                               icon={<Icon name='search' inverted circular link onClick={this.search}/>}
                               onChange={this.inputChange} placeholder='Search...'/>
                        <Button inverted className={'function-buttons'} onClick={this.getAll}>All products</Button>
                        <Button inverted className={'function-buttons'} onClick={this.createTopFive}>Top Five Bikes</Button>
                        <NewProductModal/>
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
                <Bicycles bikes={this.state.bikes}/>
            </div>
        )
    };
}
