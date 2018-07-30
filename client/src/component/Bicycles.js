import React from 'react';
import Bike from "./Bike";
import axios from 'axios'

export default class Bicycles extends React.Component {
    constructor() {
        super();
        this.state = {
            productId: [],
            name: [],
            productNumber: [],
            color: [],
            safetyStockLevel: [],
            reorderPoint: [],
            standardCost: [],
            listPrice: [],
            size: [],
            weight: [],
            productLine: [],
            clazz: [],
            style: [],
            modifiedDate: [],
            thumbNailPhoto: [],
            arr: []
        }
    }

    componentDidMount() {
        axios
            .get('http://localhost:8080/bike/getTop')
            .then(({data}) => {
                console.log(data);
                this.setState({
                    arr: data
                });
            });

    }

    createTop = () => {
        let result = [];

        result = this.state.arr.map((item) => {
            return <Bike data={item}/>
        });

        return result;
    };

    search = (id) => {
        axios
            .get('localhost:8080/bike/search/' + id)
            .then(({data}) => {
                console.log(data);
                this.setState({
                    arr: data,
                });
            });
        let result = [];

        result = this.state.arr.map((item) => {
            return <Bike data={item}/>
        });

        return result;
    };

    render() {
        return (
            <div>
                {this.createTop()}
                {this.search('road-650')}
            </div>
        )
    }

}
