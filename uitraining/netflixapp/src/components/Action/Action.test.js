import React from 'react';
import { shallow } from 'enzyme';
import Action from './Action';

describe('<Action />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Action />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
