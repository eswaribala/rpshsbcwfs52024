import React from 'react';
import { shallow } from 'enzyme';
import Login from './Login';

describe('<Login />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Login />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
