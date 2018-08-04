import axios from 'axios';


export const topFiveRequest = () => {
    return (axios .get('http://localhost:8080/bike/getTop'))
};

export const searchRequest = (input) => {
        return (axios.get('http://localhost:8080/bike/search/' + input))
};

export const getAllRequest = () => {
    return(axios.get('http://localhost:8080/bike/getAll'))
};

export const getPictureById = (productId) => {
    return(axios.get('http://localhost:8080/photo/get/' + productId))
};