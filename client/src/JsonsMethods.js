import React from 'react';

    export const getById = (id) => {
        return fetch('http://localhost:8080/bike/get/' + id, {
            method: "GET",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            }
        })
            .then(function (response) {
                return response.json();
            });
}
