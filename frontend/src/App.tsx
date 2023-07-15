
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./routes/Home/Index";
import Lists from "./routes/Lists";
import ListsBody from "./routes/Lists/ListsBody";
import Games from "./routes/Lists/Games";
import Game from "./routes/Lists/Games/Game";
import GamesBody from "./routes/Lists/Games/GamesBody";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/lists/" element={<Lists />}> 
          <Route index element={<ListsBody />} />
          <Route path=":listId/" element={<Games />}>
            <Route path="games" element={<GamesBody />} />
            <Route path="games/:gameId" element={<Game />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}
