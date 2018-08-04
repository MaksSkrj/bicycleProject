import react from 'react';
import {topFiveRequest, searchRequest, getAllRequest, getPictureById} from '../api/BikeRequests';

export const getTopFiveRes = () => {
    return (
        topFiveRequest()
        .then(res => res.data)
    )
};

export const getSearchRes = (input) => {
    return (
        searchRequest(input)
            .then(res => res.data)
    )
};

export const getAllRes = () => {
    return (
        getAllRequest()
            .then(res => res.data)
    )
};

export const getPictureRes = (productId) => {
    return (
        getPictureById(productId)
            .then(res => res.data)
    )
};
