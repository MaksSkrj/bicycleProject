import React from 'react';
import './index.css';
import {getById} from "./JsonsMethods";


class App extends React.Component{
    render() {
        return(
            <div>
                <div>
                    <h1>{this.props.headerProp}</h1>
                    <h2>{this.props.contentProp}</h2>
                </div>
                <div>
                    <button onClick="f()" className="Cancel button">Clear</button>
                </div>
            </div>

        );

    }
}

function f() {
    console.log(getById(5))

}

export default App;

