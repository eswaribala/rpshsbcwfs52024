import React from 'react';
import { shallow } from 'enzyme';
import Timer from './Timer';

describe('<Timer />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Timer />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
