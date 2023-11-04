import {Navigate} from "react-router-dom";
import { Routes, Route } from "react-router-dom";
import Alerts from "./views/Notice/Alerts";
import FullLayout from "./layouts/FullLayout";
import Badges from "./views/ui/Badges";
import Buttons from "./views/ui/Buttons";
import Grid from "./views/ui/Grid";
import Notice from "./views/Notice/Notice";
import Tables from "./views/ui/Tables";
import Updates from "./views/Notice/Updates";
import Writes from "./views/Notice/Writes";
import Forms from "./views/ui/Forms";
import Breadcrumbs from "./views/ui/Breadcrumbs";
import Manager from "./views/ui/Manage";

import Login from "./views/auth/Login";
import Signup from "./views/auth/Signup";

const App = () => {

 /* const onCreate=(date, schedule, start_time, end_time){

  }*/

  return (
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />

        <Route path="/" element={<FullLayout />}>
          <Route index element={<Navigate to="/login" />} />
          <Route path="/alerts" element={<Alerts />} />
          <Route path="/badges" element={<Badges />} />
          <Route path="/buttons" element={<Buttons />} />
          <Route path="/grid" element={<Grid />} />
          <Route path="/notice/:index" element={<Notice />} />
          <Route path="/table" element={<Tables />} />
          <Route path="/Update" element={<Updates />} />
          <Route path="/write" element={<Writes />} />
          <Route path="/forms" element={<Forms />} />
          <Route path="/breadcrumbs" element={<Breadcrumbs />} />
          <Route path="/manage" element={<Manager/>}/>
        </Route>
      </Routes>
  );
};

export default App;
