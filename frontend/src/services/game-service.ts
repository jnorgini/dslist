import axios from "axios";
import { BACKEND_URL } from "../util/system";

export function findByListRequest(listId: number) {
  return axios.get(`${BACKEND_URL}/lists/${listId}/games`);
}

export function findByIdRequest(gameId: number) {
  return axios.get(`${BACKEND_URL}/games/${gameId}`);
}
