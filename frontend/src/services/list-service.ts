import axios, { AxiosRequestConfig } from "axios";
import { BACKEND_URL } from "../util/system";

export function findAllRequest() {
  return axios.get(`${BACKEND_URL}/lists`);
}

export function findByIdRequest(listId: number) {
  return axios.get(`${BACKEND_URL}/lists/${listId}/games`);
}

export function move(
  listId: number,
  sourceIndex: number,
  destinationIndex: number
) {
  
  const config: AxiosRequestConfig = {
    method: "POST",
    url: `/lists/${listId}/replacement`,
    data: {
      sourceIndex,
      destinationIndex
    },
    baseURL: BACKEND_URL,
  };
  return axios(config);
}
