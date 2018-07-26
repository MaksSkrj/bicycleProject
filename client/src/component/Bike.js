import React from 'react';

export default class Bike extends React.Component {

    // constructor() {
    //     super();
    //     this.state = {
    //         // productId: "",
    //         // name: "",
    //         // productNumber: "",
    //         // color: "",
    //         // safetyStockLevel: "",
    //         // reorderPoint: "",
    //         // standardCost: "",
    //         // listPrice: "",
    //         // size: "",
    //         // weight: "",
    //         // productLine: "",
    //         // clazz: "",
    //         // style: "",
    //         // modifiedDate: ""
    //     }
    // };

    render() {
        return (
            <td>
                    <div className='bike-picture-div'> picture</div>
                    <div className={'bike-name-div'}>
                        <div id={"name"}>{this.props.data.name}</div>
                    </div>
            </td>
        );
    };
}