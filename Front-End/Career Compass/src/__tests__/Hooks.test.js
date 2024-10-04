import { shallow } from "enzyme";
import BillerStatement from "../screens/BILLER/BillerStatement";

it("renders Statement header", () => {
  const wrapper = shallow(<BillerStatement />);
  const header = (
    <h1>
      <center>Statement</center>
    </h1>
  );
  expect(wrapper.contains(header)).toEqual(true);
  expect(wrapper.find("#registry")).toBeTruthy();
});
