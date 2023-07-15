export type GameDTO = {
    id: number;
    title: string;
    year: number;
    genre: string;
    platforms: string;
    score: number;
    imgUrl: string;
    shortDescription: string;
    longDescription: string;
    listId: number;
}

export type GameMinDTO = {
    id: number;
    title: string;
    year: number;
    imgUrl: string;
    shortDescription: string;
}
