import React from 'react';
import Bike from "./Bike";
import axios from 'axios'

let obj = {
    productId: 'bmx',
    type: 'bla',
    img: 'car'
};

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
            modifiedDate: []
        }
    }

    componentDidMount() {
        axios
            .get('http://localhost:8080/bike/getTop')
            .then(({data})=> {
                console.log(data);
                this.setState({
                    productId: data,
                    name: data
                });
            });
    }

createTop = () => {

    let result = [];

    result = this.state.productId.map((item) => {
        return <Bike data={item}/>
    });

    return result;

};

    render() {
        return (
            <div>
                <table className='bike-table' border="1">
                    <th>
                        {this.createTop()}
                    </th>
                </table>
            </div>

        )
    }

}