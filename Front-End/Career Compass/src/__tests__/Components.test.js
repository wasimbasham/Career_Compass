import { shallow } from "enzyme";
import BillerRegister from "../screens/BILLER/BillerRegister";
import BillerProvider from "../screens/BILLER/BillerProvider";
import BillerStatement from "../screens/BILLER/BillerStatement";

test("Biller Register renders without crashing", () => {
  shallow(<BillerRegister />);
});

test("Biller Provider renders without crashing", () => {
  shallow(<BillerProvider />);
});

test("Biller Statement renders without crashing", () => {
  shallow(<BillerStatement />);
});

