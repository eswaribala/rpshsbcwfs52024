import React from 'react';
import { shallow } from 'enzyme';
import Logout from './Logout';

describe('<Logout />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Logout />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
